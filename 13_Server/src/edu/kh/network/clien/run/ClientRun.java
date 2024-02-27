package edu.kh.network.clien.run;

import edu.kh.network.client.model.service.ClientService;

public class ClientRun {
	public static void main(String[] args) {
		new ClientService().clientStart();
	}
}