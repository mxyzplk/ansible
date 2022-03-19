# SCRIPT-DB-RESTORE

The aim of this script is to consolidate the knowledge about ansible tasks, variables and functions.
This script intends to download a SQL dump file and recreate a database.

## Things that should be implemented/tested:

- A routine to select the SQL dump file
- A clean-up step do remove the temporary files
- The access toward the Service throuth access keys are still to be tested in AWS and implemented in OCI
- Logs

# Requirements:

Some ansible modules should be installed:
- amazon.aws
- oracle.oci
- community.mysql   

## Hosts file

This file contains the inventory with the host connection data.

## Pipeline

The groovy pipeline at the moment only calls the playbook. Other features may be implemented there like the clean-up step, the ansible requirements installations, a routine that scans the current backup files stored in the bucket and selects the one to be used for restoration.

## Jenkins variables

The script will look into a variable yml file named {{ ENV }}.yml before looking at the default.yml. The ENV variable is set in jenkins and selects the host aswell.

## Variables:

*ANSIBLE_USER:* this variable stores the user that will manipulate the data through the script

*DB_NAME:* database name

*CLOUD_SERVICE:* this variables affects where the db will be restores. The options are:
- "oci" for a OCI bucket
- "aws" for a AWS bucket
- "local" for a folder which could be a docker volume

*DB_TYPE:* this variable affects the dp creation command. The options are:
- "postgresql"
- "mysql"

*FILENAME:* name of the dump file

*BACKUP_STORAGE_PATH:* the path of the bucket or folder where the backups are stored

## Optional Variables

*DB_USERNAME:* the db username that may be needed to create the database.

*DB_PASSWORD:* the db password that may be needed to create the database

The following variables are needed if the script is run outside the network where the database will be created.

*SERVICE_URL:*  Url of the aws or oci instance

*SERVICE_ACCESS_KEY:* access key

*SERVICE_SECRET_KEY:* secret key
