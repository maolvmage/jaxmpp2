/*
 * Tigase XMPP Client Library
 * Copyright (C) 2006-2014 Tigase, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. Look for COPYING file in the top folder.
 * If not, see http://www.gnu.org/licenses/.
 */
package tigase.jaxmpp.core.client.connector;

import tigase.jaxmpp.core.client.Context;
import tigase.jaxmpp.core.client.XmppModulesManager;

public class WebSocketXmppSessionLogic extends AbstractSocketXmppSessionLogic<AbstractWebSocketConnector> {
	
	public WebSocketXmppSessionLogic(AbstractWebSocketConnector connector, XmppModulesManager modulesManager, Context context) {
		super(connector, modulesManager, context);
	}
	
}