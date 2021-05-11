package pt.ulisboa.ewp.host.plugin.skeleton.provider;

import java.util.Optional;

import eu.erasmuswithoutpaper.api.factsheet.v1.FactsheetResponseV1.Factsheet;

/**
 * A provider that allows EWP Node to obtain fact sheet data from the host.
 */
public abstract class FactSheetsHostProvider extends HostProvider {

    /**
     * Returns an optional with the fact sheet data for a given HEI ID.
     * If the plugin cannot resolve some HEI ID then it must return an empty result.
     *
     * @param heiId HEI ID of the institution.
     * @return Optional of fact sheet, if applicable.
     */
    public abstract Optional<Factsheet> findByHeiId(String heiId);
}
