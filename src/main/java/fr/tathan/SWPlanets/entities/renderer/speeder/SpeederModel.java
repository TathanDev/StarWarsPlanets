
package fr.tathan.SWPlanets.entities.renderer.speeder;
// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.tathan.SWPlanets.SWPlanets;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
/**
@OnlyIn(Dist.CLIENT)
public class SpeederModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SWPlanets.MODID, "speeder"), "main");
	private final ModelPart Base;
	private final ModelPart cockpit;
	private final ModelPart Chairs;
	private final ModelPart Prupulseurs1;
	private final ModelPart Prupulseurs2;
	private final ModelPart Prupulseurs3;

	public SpeederModel(ModelPart root) {
		this.Base = root.getChild("Base");
		this.cockpit = root.getChild("cockpit");
		this.Chairs = root.getChild("Chairs");
		this.Prupulseurs1 = root.getChild("Prupulseurs1");
		this.Prupulseurs2 = root.getChild("Prupulseurs2");
		this.Prupulseurs3 = root.getChild("Prupulseurs3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Base = partdefinition.addOrReplaceChild("Base", CubeListBuilder.create().texOffs(11, 1).addBox(-5.0F, -1.0F, -11.0F, 17.0F, 0.0F, 21.0F, new CubeDeformation(0.0F))
				.texOffs(0, 40).addBox(12.0F, -9.0F, -15.0F, 1.0F, 8.0F, 30.0F, new CubeDeformation(0.0F))
				.texOffs(40, 52).addBox(13.0F, -9.0F, -13.0F, 2.0F, 8.0F, 26.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(15.0F, -9.0F, -12.0F, 2.0F, 8.0F, 24.0F, new CubeDeformation(0.0F))
				.texOffs(70, 40).addBox(17.0F, -9.0F, -11.0F, 2.0F, 8.0F, 22.0F, new CubeDeformation(0.0F))
				.texOffs(59, 91).addBox(19.0F, -9.0F, -10.0F, 1.0F, 8.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-23.0F, -9.0F, -16.0F, 18.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cockpit = partdefinition.addOrReplaceChild("cockpit", CubeListBuilder.create().texOffs(96, 32).addBox(-15.0F, -9.0F, -12.0F, 4.0F, 8.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(33, 86).addBox(10.0F, -9.0F, -12.0F, 5.0F, 8.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(96, 14).addBox(-10.0F, -9.0F, -12.0F, 20.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(39, 2).addBox(-11.0F, -9.0F, -12.0F, 2.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Chairs = partdefinition.addOrReplaceChild("Chairs", CubeListBuilder.create().texOffs(96, 0).addBox(-10.0F, -14.0F, 3.0F, 19.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Prupulseurs1 = partdefinition.addOrReplaceChild("Prupulseurs1", CubeListBuilder.create().texOffs(80, 70).addBox(-23.0F, -16.5F, 8.0F, 9.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Prupulseurs2 = partdefinition.addOrReplaceChild("Prupulseurs2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r1 = Prupulseurs2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 78).addBox(-18.0F, -16.5F, -23.0F, 9.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r2 = Prupulseurs2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(2.4843F, -10.6678F, -2.6297F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -11.0F, -10.0F, -3.1359F, 0.9685F, 1.6069F));

		PartDefinition cube_r3 = Prupulseurs2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 99).addBox(-6.464F, -13.6449F, -2.6814F, 5.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.0F, 11.0F, 0.0F, 0.7854F, -1.5272F));

		PartDefinition Prupulseurs3 = partdefinition.addOrReplaceChild("Prupulseurs3", CubeListBuilder.create().texOffs(81, 91).addBox(-34.0F, -18.5F, -5.0F, 16.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r4 = Prupulseurs3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 13).addBox(-17.1388F, -23.1726F, -4.0F, 4.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.48F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		cockpit.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Chairs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Prupulseurs1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Prupulseurs2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Prupulseurs3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
 */