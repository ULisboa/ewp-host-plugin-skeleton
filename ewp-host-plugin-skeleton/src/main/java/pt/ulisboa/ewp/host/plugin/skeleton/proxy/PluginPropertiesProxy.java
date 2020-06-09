package pt.ulisboa.ewp.host.plugin.skeleton.proxy;

public interface PluginPropertiesProxy {

  /**
   * Returns the value configured configured on the EWP Node, specific for the plugin, if existing.
   * If the property does not exist then null is returned.
   *
   * @param key Property key on the context of the plugin.
   * @return Property value or null, if not existing.
   */
  String getPropertyAsString(String key);

}
