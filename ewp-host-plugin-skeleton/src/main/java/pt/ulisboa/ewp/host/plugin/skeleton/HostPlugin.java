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
     * 
     * @return A proxy to access plugin properties.
     */
    public PluginPropertiesProxy getProperties() {
        return pluginPropertiesProxy;
    }

    @Override
    public void setPluginPropertiesProxy(PluginPropertiesProxy pluginPropertiesProxy) {
        this.pluginPropertiesProxy = pluginPropertiesProxy;
    }

    /**
     * Returns all covered HEI IDs by the host.
     * 
     * @return Covered HEI IDs by the host
     */
    public abstract Collection<String> getCoveredHeiIds();

    /**
     * Returns all organizational unit IDs covered, by the current host plugin, for a specific heiId.
     * 
     * @param heiId The HEI ID (schac code)
     */
    public abstract Collection<String> getCoveredOunitIdsByHeiId(String heiId);

    /**
     * Returns all organizational unit codes covered, by the current host plugin, for a specific heiId.
     *
     * @param heiId The HEI ID (schac code)
     */
    public abstract Collection<String> getCoveredOunitCodesByHeiId(String heiId);

    /**
     * Indicates whether, for the given heiId, the current host plugin is to be used
     * by default, for InterInstitutional Agreements / Outgoing Mobilities, when the EWP Node cannot redirect a request to a
     * specific host plugin.
     * For instance, when obtaining data of an InterInstitutional Agreement that does not have an ounit_id set.
     * 
     * @param heiId The target HEI ID (schac code)
     */
    public abstract boolean isPrimaryForHeiId(String heiId);

}
