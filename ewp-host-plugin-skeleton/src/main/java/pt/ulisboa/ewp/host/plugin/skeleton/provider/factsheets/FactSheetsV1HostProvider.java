package pt.ulisboa.ewp.host.plugin.skeleton.provider.factsheets;

import eu.erasmuswithoutpaper.api.factsheet.v1.FactsheetResponseV1.Factsheet;
import java.util.Optional;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to obtain fact sheet data from the host (V1).
 */
public abstract class FactSheetsV1HostProvider extends HostVersionedProvider {

    /**
     * Returns an optional with the fact sheet data for a given HEI ID.
     * If the plugin cannot resolve some HEI ID then it must return an empty result.
     *
     * @param heiId HEI ID of the institution.
     * @return Optional of fact sheet, if applicable.
     */
    public abstract Optional<Factsheet> findByHeiId(String heiId);

    @Override
    public String getVersion() {
        return "1.1.0";
    }
}
