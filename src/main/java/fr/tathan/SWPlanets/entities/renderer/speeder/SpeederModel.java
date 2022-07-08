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

		PartDefinition Base = partdefinition.addOrReplaceChild("Base", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, -10.0F, -8.0F, 17.0F, 0.0F, 19.0F, new CubeDeformation(0.0F))
		.texOffs(45, 36).addBox(21.0F, -18.0F, -13.0F, 1.0F, 8.0F, 30.0F, new CubeDeformation(0.0F))
		.texOffs(45, 40).addBox(22.0F, -18.0F, -11.0F, 2.0F, 8.0F, 26.0F, new CubeDeformation(0.0F))
		.texOffs(45, 42).addBox(24.0F, -18.0F, -10.0F, 2.0F, 8.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(50, 44).addBox(26.0F, -18.0F, -9.0F, 2.0F, 8.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(10, 34).addBox(-14.0F, -18.0F, -14.0F, 18.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cockpit = partdefinition.addOrReplaceChild("cockpit", CubeListBuilder.create().texOffs(42, 49).addBox(-13.0F, -18.0F, -21.0F, 5.0F, 8.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(37, 49).addBox(11.0F, -18.0F, -21.0F, 6.0F, 8.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(43, 28).addBox(-8.0F, -18.0F, -21.0F, 19.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Chairs = partdefinition.addOrReplaceChild("Chairs", CubeListBuilder.create().texOffs(23, 114).addBox(-8.0F, -23.0F, -6.0F, 19.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Prupulseurs1 = partdefinition.addOrReplaceChild("Prupulseurs1", CubeListBuilder.create().texOffs(53, 42).addBox(-21.0F, -25.5F, -1.0F, 9.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Prupulseurs2 = partdefinition.addOrReplaceChild("Prupulseurs2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r1 = Prupulseurs2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(78, 42).addBox(-20.0F, -26.5F, -14.0F, 9.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r2 = Prupulseurs2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 14).addBox(-4.4431F, -1.9608F, 3.8663F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -11.0F, -10.0F, -3.1359F, 0.9685F, 1.6069F));

		PartDefinition cube_r3 = Prupulseurs2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 14).addBox(-1.2427F, -5.0461F, 5.3683F, 5.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.0F, 11.0F, 0.0F, 0.7854F, -1.5272F));

		PartDefinition Prupulseurs3 = partdefinition.addOrReplaceChild("Prupulseurs3", CubeListBuilder.create().texOffs(75, 11).addBox(-25.0F, -27.5F, -3.0F, 16.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r4 = Prupulseurs3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(37, 0).addBox(-5.0F, -27.0F, -2.0F, 4.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.48F));

		return LayerDefinition.create(meshdefinition, 128, 128);
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