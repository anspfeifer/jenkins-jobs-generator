package com.anselmopfeifer.aws.s3


import com.amazonaws.services.s3.model.Bucket
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.ObjectListing
import com.amazonaws.services.s3.model.S3ObjectSummary



class CopyToS3 {

    private static String bucketName = 'devops-chef-us'
    private static String keyName = 'test/'
    private static String filePath = '/Users/anselmo/Desktop/devops/continuous-deployment/jenkins/jenkins-jobs-generator/README.md'


    public static void main(String[] args) throws IOException {
        final AmazonS3 amazonS3Client = AmazonS3ClientBuilder.defaultClient()
        //List Buckets
        List<Bucket> buckets = amazonS3Client.listBuckets()
        println("Your Amazon S3 buckets are:")
        for (Bucket b : buckets) {
            System.out.println("* " + b.getName())
        }

        // List Objects in Bucket
        ObjectListing objectListing = amazonS3Client.listObjects(bucketName)
        List<S3ObjectSummary> objects = objectListing.getObjectSummaries()
        println("Your Amazon S3 buckets are:")
        for (S3ObjectSummary objectSummary: objects) {
            System.out.println("* " + objectSummary.getKey())
        }




    }
}


//
//try {
//    println('Uploading a new object to S3 from a file')
//    s3Client.putObject(new PutObjectRequest(bucketName, keyName, fileName, new ObjectMetadata()))
//
//} catch (AmazonServiceException ase) {
//    println('Caught an AmazonServiceException, which ' +
//            'means your request made it ' +
//            'to Amazon S3, but was rejected with an error response' +
//            'for some reason.')
//    println('Error Message:    ' + ase.getMessage())
//    println('HTTP Status Code: ' + ase.getStatusCode())
//    println('AWS Error Code:   ' + ase.getErrorCode())
//    println('Error Type:       ' + ase.getErrorType())
//    println('Request ID:       ' + ase.getRequestId())
//} catch (AmazonClientException ace) {
//    println('Caught an AmazonClientException, which ' +
//            'means the client encountered ' +
//            'an internal error while trying to ' +
//            'communicate with S3, ' +
//            'such as not being able to access the network.')
//    println('Error Message: ' + ace.getMessage())
//}