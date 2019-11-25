class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();
        for (int i = 0; i < secret.length(); i++){
        	char chS = secret.charAt(i);
        	char chG = guess.charAt(i);
        	if (chS == chG) bull++;
        	else {
        		secretMap.put(chS, secretMap.getOrDefault(chS, 0) + 1);
        		guessMap.put(chG, guessMap.getOrDefault(chG, 0) + 1);
        	}
        }
        for (char ch: secretMap.keySet()){
        	cow += Math.min(secretMap.get(ch), guessMap.getOrDefault(ch, 0));
        }
        return bull + "A" + cow + "B";
    }
}

//ACC