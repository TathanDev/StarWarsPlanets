package fr.tathan.SWPlanets.entities;
/**
import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.gui.speeder.SpeederGUI;
import fr.tathan.SWPlanets.registries.ItemsRegistry;
import io.netty.buffer.Unpooled;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import net.minecraftforge.network.NetworkHooks;
import net.mrscauthd.beyond_earth.BeyondEarthMod;
import net.mrscauthd.beyond_earth.entities.VehicleEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SpeederEntity extends VehicleEntity {

    private double speed = 0;

    public float flyingSpeed = 0.02F;

    private float FUEL_USE_TICK = 8;
    private float FUEL_TIMER = 0;

    public float animationSpeedOld;
    public float animationSpeed;
    public float animationPosition;


    public static final EntityDataAccessor<Integer> FUEL = SynchedEntityData.defineId(SpeederEntity.class, EntityDataSerializers.INT);

    public static final EntityDataAccessor<Boolean> FORWARD = SynchedEntityData.defineId(SpeederEntity.class, EntityDataSerializers.BOOLEAN);

    public static final int FUEL_BUCKETS = 3;


    public SpeederEntity(EntityType type, Level worldIn) {
        super(type, worldIn);
        this.entityData.define(FUEL, 0);
        this.entityData.define(FORWARD, false);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public void push(Entity p_21294_) {
    }

    @Deprecated
    public boolean canBeRiddenInWater() {
        return true;
    }

    @Override
    public boolean rideableUnderWater() {
        return true;
    }

    @Override
    public double getPassengersRidingOffset() {
        return super.getPassengersRidingOffset() - 0.15;
    }


    @Override
    protected void removePassenger(Entity passenger) {
        if (passenger.isCrouching() && !passenger.level.isClientSide) {
            if (passenger instanceof ServerPlayer) {
                this.setSpeed(0f);
            }
        }
        super.removePassenger(passenger);
    }

    @Override
    public ItemStack getPickedResult(HitResult target) {
        ItemStack itemStack = new ItemStack(ItemsRegistry.SPEEDER_ITEM.get(), 1);
        itemStack.getOrCreateTag().putInt(SWPlanets.MODID + ":fuel", this.entityData.get(FUEL));

        return itemStack;
    }

    @Override
    public void kill() {
        this.spawnSpeederItem();
        this.dropEquipment();

        if (!this.level.isClientSide) {
            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    public AABB getBoundingBoxForCulling() {
        return new AABB(this.getX(), this.getY(), this.getZ(), this.getX(), this.getY(), this.getZ()).inflate(4.5,4.5,4.5);
    }

    @Override
    public boolean hurt(DamageSource source, float p_21017_) {
        if (!source.isProjectile() && source.getEntity() != null && source.getEntity().isCrouching() && !this.isVehicle()) {
            this.spawnSpeederItem();
            this.dropEquipment();

            if (!this.level.isClientSide) {
                this.remove(RemovalReason.DISCARDED);
            }
            return true;
        }

        return false;
    }

    protected void spawnSpeederItem() {
        ItemStack itemStack = new ItemStack(ItemsRegistry.SPEEDER_ITEM.get(), 1);
        itemStack.getOrCreateTag().putInt(BeyondEarthMod.MODID + ":fuel", this.getEntityData().get(FUEL));

        ItemEntity entityToSpawn = new ItemEntity(level, this.getX(), this.getY(), this.getZ(), itemStack);
        entityToSpawn.setPickUpDelay(10);
        level.addFreshEntity(entityToSpawn);
    }

    protected void dropEquipment() {
        for (int i = 0; i < inventory.getSlots(); ++i) {
            ItemStack itemstack = inventory.getStackInSlot(i);
            if (!itemstack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemstack)) {
                this.spawnAtLocation(itemstack);
            }
        }
    }

    private final ItemStackHandler inventory = new ItemStackHandler(9) {
        @Override
        public int getSlotLimit(int slot) {
            return 64;
        }
    };

    private final CombinedInvWrapper combined = new CombinedInvWrapper(inventory);

    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
        if (this.isAlive() && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && side == null) {
            return LazyOptional.of(() -> combined).cast();
        }
        return super.getCapability(capability, side);
    }

    public IItemHandlerModifiable getItemHandler() {
        return (IItemHandlerModifiable) this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).resolve().get();
    }




    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        compound.put("InventoryCustom", inventory.serializeNBT());

        compound.putInt("fuel", this.getEntityData().get(FUEL));
        compound.putBoolean("forward", this.getEntityData().get(FORWARD));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        Tag inventoryCustom = compound.get("InventoryCustom");
        if (inventoryCustom instanceof CompoundTag) {
            inventory.deserializeNBT((CompoundTag) inventoryCustom);
        }

        this.entityData.set(FUEL, compound.getInt("fuel"));
        this.entityData.set(FORWARD, compound.getBoolean("forward"));
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        super.interact(player, hand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level.isClientSide);

        if (!this.level.isClientSide) {
            if (player.isCrouching()) {
                NetworkHooks.openGui((ServerPlayer) player, new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return SpeederEntity.this.getDisplayName();
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                        FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                        packetBuffer.writeVarInt(SpeederEntity.this.getId());
                        return new SpeederGUI.GuiContainer(id, inventory, packetBuffer);
                    }
                }, buf -> {
                    buf.writeVarInt(this.getId());
                });

                return InteractionResult.CONSUME;
            }

            player.startRiding(this);
            return InteractionResult.CONSUME;
        }

        return result;
    }

    public boolean getforward() {
        return this.entityData.get(FORWARD);
    }

    @Override
    public float getFrictionInfluencedSpeed(float p_21331_) {
        return this.onGround ? this.getSpeed() * (0.21600002F / (p_21331_ * p_21331_ * p_21331_)) : this.flyingSpeed;
    }

    @Override
    public void travel(Vec3 p_21280_) {
        if (!this.getPassengers().isEmpty() && this.getPassengers().get(0) instanceof Player) {

            Player passanger = (Player) this.getPassengers().get(0);

            this.flyingSpeed = this.getSpeed() * 0.15F;
            this.maxUpStep = 1.0F;

            double pmovement = passanger.zza;

            if (pmovement == 0 || this.getEntityData().get(FUEL) == 0 || this.isEyeInFluid(FluidTags.WATER)) {
                pmovement = 0;
                this.setSpeed(0f);

                if (speed != 0 && speed > 0.02) {
                    speed = speed - 0.02;
                }
            }

            if (this.entityData.get(FORWARD) && this.getEntityData().get(FUEL) != 0) {
                if (this.getSpeed() >= 0.01) {
                    if (speed <= 0.32) {
                        speed = speed + 0.02;
                    }
                }

                if (this.getSpeed() < 0.25) {
                    this.setSpeed(this.getSpeed() + 0.02F);
                }

            }

            if (!this.entityData.get(FORWARD)) {

                if (this.getEntityData().get(FUEL) != 0 && !this.isEyeInFluid(FluidTags.WATER)) {

                    if (this.getSpeed() <= 0.04) {
                        this.setSpeed(this.getSpeed() + 0.02f);
                    }
                }

                if (this.getSpeed() >= 0.08) {
                    this.setSpeed(0f);
                }
            }

            if (this.entityData.get(FORWARD)) {
            } else {
            }

            super.travel(new Vec3(0, 0, pmovement));
            return;
        }

        super.travel(new Vec3(0, 0, 0));
    }


}
*/