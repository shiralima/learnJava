import java.util.*;

class ChatterBot {
	static final String REQUEST_PREFIX = "say ";

	String botName;
	Random rand = new Random();
	String[] repliesToIllegalRequest;
	String[] repliesToLegalRequest;

	ChatterBot(String[] repliesToIllegalRequest, String[] repliesToLegalRequest, String botName) {
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

	String replyTo(String statement) {
		String currentReplayRequestStatement[];

		if (statement.startsWith(REQUEST_PREFIX)) {
			currentReplayRequestStatement = this.repliesToLegalRequest;
		} else {
			currentReplayRequestStatement = this.repliesToIllegalRequest;
		}
		System.out.println(currentReplayRequestStatement[0]);
		int randomIndex = rand.nextInt(currentReplayRequestStatement.length);
		String reply = currentReplayRequestStatement[randomIndex];
		if (rand.nextBoolean()) {
			reply = reply + statement;
		}
		return reply;
	}

	String getName() {
		return this.botName;
	}
}
