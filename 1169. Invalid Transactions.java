class Solution {
	class Node {
		int amount;
		int time;
		String city;
		Node(int amount, int time, String city){
			this.amount = amount;
			this.time = time;
			this.city = city;
		}
	}
    public List<String> invalidTransactions(String[] transactions) {
    	Map<String, List<Node>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String transaction: transactions){
        	String[] arr = transaction.split(",");
        	String name = arr[0];
        	int time = Integer.parseInt(arr[1]);
        	int amount = Integer.parseInt(arr[2]);
        	String city = arr[3];
        	List<Node> list = map.get(name);
        	if (list == null){
        		list = new ArrayList<>();
        	}
        	list.add(new Node(amount, time, city));
        	map.put(name, list);
        }

        for (String name: map.keySet()){
        	List<Node> list = map.get(name);
        	Collections.sort(list, (n1, n2) -> n1.time - n2.time);
        	for (int i = 0; i < list.size(); i++){
        		Node cur = list.get(i);
        		String trans = name + "," + cur.time + "," + cur.amount + "," + cur.city;
        		if (cur.amount > 1000){
                    res.add(trans);
                    continue;
                }
        		if (i > 0){
        			Node pre = list.get(i - 1);
        			if (cur.time - pre.time <= 60 && !cur.city.equals(pre.city)){
        				res.add(trans);
                        continue;
        			}
        		}
        		if (i < list.size() - 1){
        			Node next = list.get(i + 1);
        			if (next.time - cur.time <= 60 && !cur.city.equals(next.city)){
        				res.add(trans);
                        continue;
        			}
        		}
        	}
        }
        return res;
    }
}

//ACC