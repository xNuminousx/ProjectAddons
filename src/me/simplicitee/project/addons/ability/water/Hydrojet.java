package me.simplicitee.project.addons.ability.water;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.projectkorra.projectkorra.ability.AddonAbility;
import com.projectkorra.projectkorra.ability.PassiveAbility;
import com.projectkorra.projectkorra.ability.WaterAbility;

import me.simplicitee.project.addons.ProjectAddons;

public class Hydrojet extends WaterAbility implements AddonAbility, PassiveAbility {

	private int amp;
	
	public Hydrojet(Player player) {
		super(player);
		
		amp = ProjectAddons.instance.getConfig().getInt("Passives.Water.Hydrojet.Speed");
	}

	@Override
	public void progress() {
		if (player.isSwimming()) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 25, amp), true);
		}
	}

	@Override
	public boolean isSneakAbility() {
		return false;
	}

	@Override
	public boolean isHarmlessAbility() {
		return false;
	}

	@Override
	public long getCooldown() {
		return 0;
	}

	@Override
	public String getName() {
		return "Hydrojet";
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
		return ProjectAddons.instance.getConfig().getBoolean("Passives.Water.Hydrojet.Enabled");
	}
	
	@Override
	public String getInstructions() {
		return "Go swimming";
	}
	
	@Override
	public String getDescription() {
		return "Skilled waterbenders can boost their swimming speed by bending the water currents around them!";
	}
}
