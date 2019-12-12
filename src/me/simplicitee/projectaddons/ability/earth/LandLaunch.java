package me.simplicitee.projectaddons.ability.earth;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.projectkorra.projectkorra.ability.AddonAbility;
import com.projectkorra.projectkorra.ability.EarthAbility;
import com.projectkorra.projectkorra.ability.PassiveAbility;

import me.simplicitee.projectaddons.ProjectAddons;

public class LandLaunch extends EarthAbility implements AddonAbility, PassiveAbility {

	private int amp;
	
	public LandLaunch(Player player) {
		super(player);
		
		amp = ProjectAddons.instance.getConfig().getInt("Passives.LandLaunch.Power");
	}

	@Override
	public void progress() {
		if (player.isOnGround() && isEarthbendable(player.getLocation().getBlock().getRelative(BlockFace.DOWN))) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10, amp), true);
		}
	}

	@Override
	public boolean isSneakAbility() {
		return false;
	}

	@Override
	public boolean isHarmlessAbility() {
		return true;
	}

	@Override
	public long getCooldown() {
		return 0;
	}

	@Override
	public String getName() {
		return "LandLaunch";
	}

	@Override
	public Location getLocation() {
		return player.getLocation();
	}

	@Override
	public boolean isInstantiable() {
		return true;
	}

	@Override
	public boolean isProgressable() {
		return true;
	}

	@Override
	public void load() {
	}

	@Override
	public void stop() {
	}

	@Override
	public String getAuthor() {
		return "Simplicitee";
	}

	@Override
	public String getVersion() {
		return ProjectAddons.instance.version();
	}

	@Override
	public boolean isEnabled() {
		return ProjectAddons.instance.getConfig().getBoolean("Passives.LandLaunch.Enabled");
	}
	
	@Override
	public String getInstructions() {
		return "Jump while on earth";
	}
	
	@Override
	public String getDescription() {
		return "Skilled earthbenders can boost their jumps by bending the earth right below their feet!";
	}
}