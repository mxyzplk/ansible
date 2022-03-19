node {
    stage('DB Backup') {
        steps {
            bash '''
               #!/bin/bash
               ansible-playbook db-backup-playgroup.yml -i hosts
            '''
        }            
    }
}