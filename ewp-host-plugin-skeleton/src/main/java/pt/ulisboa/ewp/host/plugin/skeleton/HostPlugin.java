package pt.ulisboa.ewp.host.plugin.skeleton;

import java.util.Collection;

import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

import pt.ulisboa.ewp.host.plugin.skeleton.interfaces.PluginPropertiesAware;
import pt.ulisboa.ewp.host.plugin.skeleton.proxy.PluginPropertiesProxy;

public abstract class HostPlugin extends Plugin implements PluginPropertiesAware {

  private PluginPropertiesProxy pluginPropertiesProxy;

  public HostPlugin(PluginWrapper wrapper) {
    super(wrapper);
  }

  /**
   * Returns a proxy to access properties specific for the plugin configured on the EWP Node.
   * @return A proxy to access plugin properties.
   */
  public PluginPropertiesProxy getProperties() {
    return pluginPropertiesProxy;
  }

  @Override
  public void setPluginPropertiesProxy(
      PluginPropertiesProxy pluginPropertiesProxy) {
    this.pluginPropertiesProxy = pluginPropertiesProxy;
  }

  /**
   * Returns all covered HEI IDs by the host.
   * @return Covered HEI IDs by the host
   */
  public abstract Collection<String> getCoveredHeiIds();

}
