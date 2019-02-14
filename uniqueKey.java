import java.util.*;
import org.apache.commons.codec.binary.Base64;
import java.nio.*; 

class uniqueKey{
	public static void main(String[] args){
	
			
    		//System.out.println("uuid = " + UUID.randomUUID().toString().replace("-", ""));
    		HashMap<String,Integer> hm = new HashMap<String,Integer>();
    		for(int i =0;i<1000000000;i++){
    			String uuid =  uuidToBase64(UUID.randomUUID().toString());
    			if(hm.containsKey(uuid)){
    				System.out.println("Duplicate");
    				break;
    			}
    			else{
    				hm.put(uuid,1);
    			}
    		}    	
	}

	private static String uuidToBase64(String str) {
    Base64 base64 = new Base64();
    UUID uuid = UUID.fromString(str);
    ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
    bb.putLong(uuid.getMostSignificantBits());
    bb.putLong(uuid.getLeastSignificantBits());
    return base64.encodeBase64URLSafeString(bb.array());
	}
	private static String uuidFromBase64(String str) {
    Base64 base64 = new Base64(); 
    byte[] bytes = base64.decodeBase64(str);
    ByteBuffer bb = ByteBuffer.wrap(bytes);
    UUID uuid = new UUID(bb.getLong(), bb.getLong());
    return uuid.toString();
	}
}