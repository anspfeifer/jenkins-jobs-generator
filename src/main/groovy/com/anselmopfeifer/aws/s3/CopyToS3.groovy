package com.anselmopfeifer.aws.s3

import com.amazonaws.services.s3.model.Bucket
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.anselmopfeifer.utils.Configuration

static copyToS3 (fileName) {
    def config = new Configuration()
    final AmazonS3 amazonS3Client = AmazonS3ClientBuilder.defaultClient()
    List<Bucket> bucketList = amazonS3Client.lis
}
//class CopyToS3 {
//    private static String bucketName = 'devops-chef-us'
//    private static String keyName = 'test/'
//    private static String filePath = '/Users/anselmo/Desktop/devops/continuous-deployment/jenkins/jenkins-jobs-generator/README.md'
//
//
//    public static void main(String[] args) throws IOException {
//        final AmazonS3 amazonS3Client = AmazonS3ClientBuilder.defaultClient()
//        //List Buckets
//        List<Bucket> buckets = amazonS3Client.listBuckets()
//        println("Your Amazon S3 buckets are:")
//        for (Bucket b : buckets) {
//            System.out.println("* " + b.getName())
//        }
//
//        // List Objects in Bucket
//        ObjectListing objectListing = amazonS3Client.listObjects(bucketName)
//        List<S3ObjectSummary> objects = objectListing.getObjectSummaries()
//        println("Your Amazon S3 buckets are:")
//        for (S3ObjectSummary objectSummary: objects) {
//            System.out.println("* " + objectSummary.getKey())
//        }
//    }
// }