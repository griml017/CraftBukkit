package org.bukkit.craftbukkit;

import java.util.HashMap;

import org.apache.commons.lang.Validate;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.potion.Potion;

public class CraftEffect {
    public static <T> int getDataValue(Effect effect, T data) {
        int datavalue;
        switch(effect) {
        case POTION_BREAK:
            datavalue = ((Potion) data).toDamageValue() & 0x3F;
            break;
        case RECORD_PLAY:
            Validate.isTrue(((Material) data).isRecord(), "Invalid record type!");
            datavalue = ((Material) data).getId();
            break;
        case SMOKE:
        	
        	HashMap<BlockFace, Integer> setDataValue = new HashMap<BlockFace, Integer>();
        	setDataValue.put(BlockFace.SOUTH_EAST, 0);
        	setDataValue.put(BlockFace.SOUTH, 1);
        	setDataValue.put(BlockFace.SOUTH_WEST, 2);
        	setDataValue.put(BlockFace.EAST, 3);
        	setDataValue.put(BlockFace.SELF, 4);
        	setDataValue.put(BlockFace.WEST, 5);
        	setDataValue.put(BlockFace.NORTH_EAST, 6);
        	setDataValue.put(BlockFace.NORTH, 7);
        	setDataValue.put(BlockFace.NORTH_WEST, 8);
        	
        	datavalue = setDataValue.get(data);
        	
//            switch((BlockFace) data) { // TODO: Verify (Where did these values come from...?)
//            case SOUTH_EAST:
//                datavalue = 0;
//                break;
//            case SOUTH:
//                datavalue = 1;
//                break;
//            case SOUTH_WEST:
//                datavalue = 2;
//                break;
//            case EAST:
//                datavalue = 3;
//                break;
//            case UP:
//            case SELF:
//                datavalue = 4;
//                break;
//            case WEST:
//                datavalue = 5;
//                break;
//            case NORTH_EAST:
//                datavalue = 6;
//                break;
//            case NORTH:
//                datavalue = 7;
//                break;
//            case NORTH_WEST:
//                datavalue = 8;
//                break;
//            default:
//                throw new IllegalArgumentException("Bad smoke direction!");
//            }
            break;
        case STEP_SOUND:
            Validate.isTrue(((Material) data).isBlock(), "Material is not a block!");
            datavalue = ((Material) data).getId();
            break;
        default:
            datavalue = 0;
        }
        return datavalue;
    }
}
