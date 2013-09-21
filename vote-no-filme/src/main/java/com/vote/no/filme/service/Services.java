package com.vote.no.filme.service;

public class Services {
	
	private FilmeService filmeServ;
	
	private UserService userServ;
	
	private VotosService votosServ;
	
	public void setFilmeServ(FilmeService filmeServ) {
		this.filmeServ = filmeServ;
	}

	public void setUserServ(UserService userServ) {
		this.userServ = userServ;
	}

	public void setVotosServ(VotosService votosServ) {
		this.votosServ = votosServ;
	}

	public FilmeService getFilmeServ() {
		return filmeServ;
	}

	public UserService getUserServ() {
		return userServ;
	}

	public VotosService getVotosServ() {
		return votosServ;
	}
}
