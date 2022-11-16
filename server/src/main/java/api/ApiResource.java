package api;

import business.ApplicationContext;
import business.discount.Discount;
import business.discount.DiscountDAO;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import java.util.List;

@ApplicationPath("/")
@Path("/")
public class ApiResource {
    private final DiscountDAO discountDAO = ApplicationContext.INSTANCE.getDiscountDAO();

    @GET
    @Path("discounts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Discount> discount_codes(@QueryParam("limit") @DefaultValue("10") int limit,
                                         @Context HttpServletRequest httpRequest) {
        try {
            return discountDAO.getAll(limit);
        } catch(Exception e) {
            throw new ApiException("Discount Codes lookup failed", e);
        }
    }

    @GET
    @Path("discounts/{discount-id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Discount discoutById(@PathParam("discount-id") int discount_id, @Context HttpServletRequest httpRequest) {
        try {
            Discount discount = discountDAO.get(discount_id);
            if (discount == null) {
                throw new ApiException(String.format("Discount id %d not found", discount_id));
            }
            return discount;
        } catch (Exception e) {
            throw new ApiException("Exception while retrieving discount by Id", e);
        }
    }
}
