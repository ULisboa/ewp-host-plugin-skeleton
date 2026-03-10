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

  /**
   * Can be used to define if the current host provider is active or not. If inactive then it won't
   * be considered at all by the EWP Node.
   *
   * @return True if host provider is active
   */
  public boolean isActive() {
    return true;
  }
}
