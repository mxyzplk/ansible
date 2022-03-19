## Linux client SSO to AD KDC Server

This scripts configures a centos 8 client to authenticate in SSO to an Active Directory KDC.

Requirements:
collections: **ansible.posix**
             **community.general**

```bash
ansible-galaxy collection install ansible.posix
ansible-galaxy collection install community.general.
```

The variables are set in vars/defaults.yml

An example playbook:

```bash
- name: Setup Kerberos
  hosts: localhost
  roles:
    - setup-krb-sssd-ad
