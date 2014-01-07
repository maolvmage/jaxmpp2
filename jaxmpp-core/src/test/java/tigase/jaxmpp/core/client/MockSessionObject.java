package tigase.jaxmpp.core.client;

import java.util.HashMap;

import tigase.jaxmpp.core.client.eventbus.EventBus;
import tigase.jaxmpp.core.client.xmpp.modules.presence.PresenceModule;
import tigase.jaxmpp.core.client.xmpp.modules.roster.RosterStore;

public class MockSessionObject extends AbstractSessionObject {

	public MockSessionObject(EventBus eventBus) {
		super();
		setEventBus(eventBus);
		properties = new HashMap<String, Entry>();
		responseManager = new ResponseManager();
		roster = new RosterStore();

		PresenceModule.setPresenceStore(this, new MockPresenceStore());
	}
}
