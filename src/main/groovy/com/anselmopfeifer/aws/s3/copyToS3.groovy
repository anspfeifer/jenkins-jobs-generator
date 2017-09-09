package com.anselmopfeifer.aws.s3

import com.amazonaws.auth.PropertiesCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.PutObjectRequest
import hudson.Util

def client = new AmazonS3Client(new PropertiesCredentials(credentialsFile.red()))
client.setEndpoint(endpoint)

def expandedObjectKey = Util.replaceMacro(objectKey, envVars)

def request = new PutObjectRequest(bucket, expandedObjectKey, filePath.read(), metadata)
if (filePath) {
    request.setCannedAcl(CannedAccessControlList.PublicRead)
}


static final copySingleFileToS3(bucketNameAndPath, file) {

}

static final copyMultiplesFilesToS3(bucketNameAndPath, path) {

}
