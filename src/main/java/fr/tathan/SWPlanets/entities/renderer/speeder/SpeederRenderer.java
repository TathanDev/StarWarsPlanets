package fr.tathan.SWPlanets.entities.renderer.speeder;


import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.entities.SpeederEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.mrscauthd.beyond_earth.entities.renderer.VehicleRenderer;

@OnlyIn(Dist.CLIENT)
public class SpeederRenderer extends VehicleRenderer<SpeederEntity, SpeederModel<SpeederEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/vehicles/speeder.png");

    public SpeederRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new SpeederModel<>(renderManagerIn.bakeLayer(SpeederModel.LAYER_LOCATION)), 0f);
    }

    @Override
    public ResourceLocation getTextureLocation(SpeederEntity p_114482_) {
        return TEXTURE;
    }

}
