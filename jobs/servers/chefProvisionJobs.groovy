import static com.anselmopfeifer.Utils.*

jobFactory.freeStyleJob('chef-provision-job') {

    description getJobDescription()

    logRotator (-1, 10)

    jdk ('Java 8')

    parameters{
        stringParam('VERSION',  'master', 'Version chef Release')
        booleanParam('EXECUTE', false, "Execute chef provision")

    }

    steps {
        conditionalSteps {
            condition {
                booleanCondition('${EXECUTE}')
            }

            runner('Fail')
            steps {
                shell ("""
                rm -rf /tmp/cookbooks*
                aws s3 cp s3://devops-chef-us/cookbooks/cookbooks_\${VERSION}.tar.gz cookbooks_\${VERSION}.tar.gz --profile chef --region us-east-1
                sudo tar -xvf cookbooks_\${VERSION}.tar.gz
                sudo rm -rf /var/chef/cookbooks
                sudo mkdir -p /var/chef && sudo mkdir -p /etc/chef/ || true
                sudo mv cookbooks /var/chef/cookbooks
                sudo aws s3 cp s3://devops-chef-us/clientes/perseu/sindetran/node.json /etc/chef/node.json --profile chef --region us-east-1
                sudo apt-get update

                sudo -i << EOF
                echo 'json_attribs "/etc/chef/node.json"' > /etc/chef/solo.rb
                EOF

                sudo chef-solo /etc/chef/node.json --legacy-mode

                sudo rm -rf /var/chef/cookbooks
                echo "Executed Chef Provision"
                """)
            }
        }
    }

    publishers {
        // email 'anspfeifer@gmail.com'
    }

}
