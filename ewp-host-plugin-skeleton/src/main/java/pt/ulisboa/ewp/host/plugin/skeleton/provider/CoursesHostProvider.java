package pt.ulisboa.ewp.host.plugin.skeleton.provider;

import eu.erasmuswithoutpaper.api.courses.v0.CoursesResponseV0.LearningOpportunitySpecification;
import java.time.LocalDate;
import java.util.Collection;
import javax.annotation.Nullable;

/**
 * A provider that allows EWP Node to obtain the list of Learning Opportunities Specification IDs from the host.
 */
public abstract class CoursesHostProvider extends HostProvider {

    private static final int DEFAULT_MAX_NUMBER_LOS_IDS_PER_REQUEST = 1;
    private static final int DEFAULT_MAX_NUMBER_LOS_CODES_PER_REQUEST = 1;

    /**
     * Returns a collection of learning opportunity specifications given their IDs.
     * If some ID is unknown then it must be ignored.
     *
     * @param heiId HEI ID of the institution that contains the intended learning opportunity specifications.
     * @param losIds Learning opportunity specification IDs to obtain.
     * @param loisBefore If not null, the response must only include learning opportunity instances conducted before the given date.
     * @param loisAfter If not null, the response must only include learning opportunity instances conducted after the given date.
     * @param losAtDate If not null and the host supports it, the learning opportunity specifications
     *                  are returned as defined on the provided date.
     *                  If not null but the host does not support it then it may be ignored.
     * @return Collection of learning opportunity specifications
     */
    public abstract Collection<LearningOpportunitySpecification> findByHeiIdAndLosIds(String heiId, Collection<String> losIds,
           @Nullable LocalDate loisBefore, @Nullable LocalDate loisAfter, @Nullable LocalDate losAtDate);

    /**
     * Returns a collection of learning opportunity specifications given their codes.
     * If some code is unknown then it must be ignored.
     *
     * @param heiId HEI ID of the institution that contains the intended learning opportunity specifications.
     * @param losCodes Learning opportunity specification codes to obtain.
     * @param loisBefore If not null, the response must only include learning opportunity instances conducted before the given date.
     * @param loisAfter If not null, the response must only include learning opportunity instances conducted after the given date.
     * @param losAtDate If not null and the host supports it, the learning opportunity specifications
     *                  are returned as defined on the provided date.
     *                  If not null but the host does not support it then it may be ignored.
     * @return Collection of learning opportunity specifications
     */
    public abstract Collection<LearningOpportunitySpecification> findByHeiIdAndLosCodes(String heiId, Collection<String> losCodes,
        @Nullable LocalDate loisBefore, @Nullable LocalDate loisAfter, @Nullable LocalDate losAtDate);

    /**
     * Indicates the maximum number of learning opportunity specification IDs that can be handled on any request.
     * 
     * @return Maximum number of learning opportunity specification IDs
     */
    public int getMaxLosIdsPerRequest() {
        return DEFAULT_MAX_NUMBER_LOS_IDS_PER_REQUEST;
    }

    /**
     * Indicates the maximum number of learning opportunity specification codes that can be handled on any request.
     * 
     * @return Maximum number of learning opportunity specification codes
     */
    public int getMaxLosCodesPerRequest() {
        return DEFAULT_MAX_NUMBER_LOS_CODES_PER_REQUEST;
    }

    @Override
    public String getVersion() {
        return "0.7.1";
    }
}
