package net.creativeparkour;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class MaterialFilter 
{
	private List<Material> materials = new ArrayList<Material>(); 
	
	public MaterialFilter(String rule)
	{
		for(Material material : Material.values())
		{
			if(!material.isLegacy())
			{
				String name = material.name();
				boolean add = false;
				//signs
				if(rule.equalsIgnoreCase("sign") && name.contains("_SIGN")) add = true;
				else if(rule.equalsIgnoreCase("wallsign") && name.contains("_WALL_SIGN")) add = true;
				else if(rule.equalsIgnoreCase("normalsign") && name.contains("_SIGN") && !name.contains("_WALL_")) add = true;
				
				if(add) this.materials.add(material);
			}
		}
	}
	
	public List<Material> getList()
	{
		return this.materials;
	}
	
	public boolean isa(Material compare)
	{
		return this.materials.contains(compare);
	}
}