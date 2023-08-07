package pt.ulisboa.ewp.host.plugin.skeleton.provider;

import org.pf4j.ExtensionPoint;
import pt.ulisboa.ewp.host.plugin.skeleton.HostPlugin;
import pt.ulisboa.ewp.host.plugin.skeleton.interfaces.PluginAware;

public abstract class HostProvider implements ExtensionPoint, PluginAware {

  protected HostPlugin hostPlugin;

  @Override
  public HostPlugin getPlugin() {
    return this.hostPlugin;
  }

  @Override
  public void setPlugin(HostPlugin hostPlugin) {
    this.hostPlugin = hostPlugin;
  }
}
