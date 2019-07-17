package com.neeson.thread.geek;

/**
 * @author : neeson
 * Date: 2019/7/17
 * Time: 22:57
 * Description: 
 */
public final class Router {

	private final String ip;

	private final Integer port;

	private final String iface;

	public Router(String ip, Integer port, String iface) {
		this.ip = ip;
		this.port = port;
		this.iface = iface;
	}

	public String getIface() {
		return iface;
	}

	public boolean equals(Object object) {
		if (object instanceof Router) {
			Router r = Router.class.cast(object);
			return iface.equals(r.iface) && port.equals(r.port) && ip.equals(r.ip);
		}
		return false;
	}
}
