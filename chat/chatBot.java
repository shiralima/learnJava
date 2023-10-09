package chat;
import java.util.*;

class ChatterBot {
	private static final String REQUEST_PREFIX = "say ";

	private String botName;
	private Random rand = new Random();
	private String[] repliesToIllegalRequest;
	private String[] repliesToLegalRequest;

	public ChatterBot(String[] repliesToIllegalRequest, String[] repliesToLegalRequest, String botName) {
		this.botName = botName;
		this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length];
		this.repliesToLegalRequest = new String[repliesToLegalRequest.length];
		for (int i = 0; i < repliesToIllegalRequest.length; i = i + 1) {
			this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];
		}
		for (int i = 0; i < repliesToLegalRequest.length; i = i + 1) {
			this.repliesToLegalRequest[i] = repliesToLegalRequest[i];
		}
	}

	public String replyTo(String statement) {
		if (statement.startsWith(REQUEST_PREFIX)) {
			return respondToLegalRequest(statement);
		}
		return respondToIllegalRequest(statement);
	}

	public String getName() {
		return this.botName;
	}

	private String respondToIllegalRequest(String statement) {
		int randomIndex = rand.nextInt(repliesToIllegalRequest.length);
		String reply = repliesToIllegalRequest[randomIndex];
		if (rand.nextBoolean()) {
			reply = reply + statement;
		}
		return reply;
	}

	private String respondToLegalRequest(String statement) {
		int randomIndex = rand.nextInt(repliesToLegalRequest.length);
		String reply = repliesToLegalRequest[randomIndex];
		if (rand.nextBoolean()) {
			reply = reply + statement;
		}
		return reply;
	}
}
