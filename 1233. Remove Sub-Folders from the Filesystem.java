class Solution {
    class Folder {
        boolean needTrim;
        Map<String, Folder> children;
        Folder(){
            children = new HashMap<>();
        }
    }
    
    public List<String> removeSubfolders(String[] folder) {
        Folder root = new Folder();
        for (String f: folder){
            help(root, f);
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(root, res, sb);
        return res;
    }
    
    void help(Folder root, String f){
        String[] arr = f.split("/");
        Folder cur = root;
        for (String a: arr){
            Map<String, Folder> map = cur.children;
            Folder child = map.get(a);
            if (child == null) {
                child = new Folder();
                map.put(a, child);
            }
            cur = child;
        }
        cur.needTrim = true;
    }
    
    void solve(Folder root, List<String> res, StringBuilder sb){
        int len = sb.length();
        for (String path: root.children.keySet()){
            Folder cur = root.children.get(path);
            sb.append("/").append(path);
            if (cur.needTrim){
                res.add(sb.toString().substring(1));
            } else {
                solve(cur, res, sb);
            }
            sb.setLength(len);
        }
    }
}

//ACC