package pt.ulisboa.ewp.host.plugin.skeleton.provider.courses.replication;

import java.util.Collection;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to obtain the list of Learning Opportunities Specification IDs from the host (V1).
 */
public abstract class SimpleCourseReplicationV1HostProvider extends HostVersionedProvider {

  /**
   * Returns the list of Learning Opportunities Specification IDs for a given HEI ID.
   * If the plugin cannot resolve the HEI ID then it must return an empty collection.
   *
   * @param heiId HEI ID of the institution
   * @return List of Learning Opportunities Specification IDs or empty, if unknown HEI ID.
   */
  public abstract Collection<String> findAllByHeiId(String heiId);

  @Override
  public String getVersion() {
    return "1.0.0";
  }
}
