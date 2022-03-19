node {
    stage('DB Backup') {
        steps {
            bash '''
               #!/bin/bash
               ansible-playbook db-restore-playgroup.yml -i hosts
            '''
        }            
    }
}