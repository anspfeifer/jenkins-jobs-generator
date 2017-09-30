package com.anselmopfeifer.aws.s3

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class ListObjects {
    public static void main(String[] args) {
        final String USAGE = "devops-chef-us"

        if (args.length < 1) {
            System.out.println(USAGE)
            System.exit(1)
        }

        String bucket_name = args[0]

        System.out.format("Objects in S3 bucket %s:\n", bucket_name)
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient()
        ObjectListing ol = s3.listObjects(bucket_name)
        List<S3ObjectSummary> objects = ol.getObjectSummaries()
        for (S3ObjectSummary os: objects) {
            System.out.println("* " + os.getKey())
        }
    }
}