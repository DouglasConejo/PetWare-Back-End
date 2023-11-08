#!/bin/bash
cd /home/ec2-user
aws s3 cp s3://petware-backend/PETWARE-0.0.1-SNAPSHOT.jar .
java -jar PETWARE-0.0.1-SNAPSHOT.jar

