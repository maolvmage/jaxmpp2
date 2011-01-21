package tigase.jaxmpp.core.client.xmpp.modules;

import tigase.jaxmpp.core.client.AsyncCallback;
import tigase.jaxmpp.core.client.JID;
import tigase.jaxmpp.core.client.PacketWriter;
import tigase.jaxmpp.core.client.SessionObject;
import tigase.jaxmpp.core.client.XMPPException;
import tigase.jaxmpp.core.client.XMPPException.ErrorCondition;
import tigase.jaxmpp.core.client.criteria.Criteria;
import tigase.jaxmpp.core.client.criteria.ElementCriteria;
import tigase.jaxmpp.core.client.exceptions.JaxmppException;
import tigase.jaxmpp.core.client.xml.DefaultElement;
import tigase.jaxmpp.core.client.xml.Element;
import tigase.jaxmpp.core.client.xml.XMLException;
import tigase.jaxmpp.core.client.xml.XmlTools;
import tigase.jaxmpp.core.client.xmpp.stanzas.IQ;
import tigase.jaxmpp.core.client.xmpp.stanzas.StanzaType;

public class PingModule extends AbstractIQModule {

	private final Criteria CRIT = ElementCriteria.name("iq").add(ElementCriteria.name("ping", "urn:xmpp:ping"));

	private final String[] FEATURES = new String[] { "urn:xmpp:ping" };

	public PingModule(SessionObject sessionObject, PacketWriter packetWriter) {
		super(sessionObject, packetWriter);
	}

	@Override
	public Criteria getCriteria() {
		return CRIT;
	}

	@Override
	public String[] getFeatures() {
		return FEATURES;
	}

	public void ping(JID jidInstance, AsyncCallback asyncCallback) throws XMLException, JaxmppException {
		IQ iq = IQ.create();
		iq.setType(StanzaType.get);
		iq.setTo(jidInstance);
		iq.addChild(new DefaultElement("ping", null, "urn:xmpp:ping"));

		sessionObject.registerResponseHandler(iq, asyncCallback);
		writer.write(iq);
	}

	@Override
	protected void processGet(IQ stanza) throws XMPPException, XMLException, JaxmppException {
		Element response = XmlTools.makeResult(stanza);

		writer.write(response);
	}

	@Override
	protected void processSet(IQ stanza) throws XMPPException, XMLException {
		throw new XMPPException(ErrorCondition.not_allowed);
	}

}
