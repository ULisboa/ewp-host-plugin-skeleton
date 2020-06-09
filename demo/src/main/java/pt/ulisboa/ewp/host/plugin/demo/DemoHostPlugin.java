package pt.ulisboa.ewp.host.plugin.demo;

import java.util.Collection;
import java.util.Collections;

import org.pf4j.PluginWrapper;

import pt.ulisboa.ewp.host.plugin.skeleton.HostPlugin;

public class DemoHostPlugin extends HostPlugin {

  private static DemoHostPlugin instance;

  public DemoHostPlugin(PluginWrapper wrapper) {
    super(wrapper);
    instance = this;
  }

  public static DemoHostPlugin getInstance() {
    return instance;
  }

  @Override
  public Collection<String> getCoveredHeiIds() {
    return Collections.singletonList("example.com");
  }
}
