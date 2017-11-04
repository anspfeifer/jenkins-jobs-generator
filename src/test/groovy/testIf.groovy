class Configuration {
    static String bucketName = 'devops-backup-us'
    static String username = 'root'
    static String password = '123'
    static String hostname = 'localhost'
}

def config = new Configuration()

println config.bucketName?: 'aaa'