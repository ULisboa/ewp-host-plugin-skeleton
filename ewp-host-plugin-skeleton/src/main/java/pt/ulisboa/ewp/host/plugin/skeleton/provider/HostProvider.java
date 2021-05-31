package pt.ulisboa.ewp.host.plugin.skeleton.provider;

import org.pf4j.ExtensionPoint;

public abstract class HostProvider implements ExtensionPoint {

  public abstract String getVersion();

}
