package pt.ulisboa.ewp.host.plugin.skeleton.interfaces;

import pt.ulisboa.ewp.host.plugin.skeleton.HostPlugin;

public interface PluginAware extends AwareInterface {

  HostPlugin getPlugin();

  void setPlugin(HostPlugin hostPlugin);

}
