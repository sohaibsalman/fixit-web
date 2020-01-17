package com.fixit.fixer;

public class Fixer 
{
	CredentialInfo credential;
	PersonalInfo personal;
	WorkInfo work;
	
	public Fixer(CredentialInfo credential, PersonalInfo personal, WorkInfo work) {
		this.credential = credential;
		this.personal = personal;
		this.work = work;
	}
  
	public CredentialInfo getCredential() {
		return credential;
	}

	public void setCredential(CredentialInfo credential) {
		this.credential = credential;
	}

	public PersonalInfo getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalInfo personal) {
		this.personal = personal;
	}

	public WorkInfo getWork() {
		return work;
	}

	public void setWork(WorkInfo work) {
		this.work = work;
	}
	
}
