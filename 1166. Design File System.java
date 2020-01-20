class FileSystem {
    class File {
        int val;
        Map<String, File> files;
        File(int val){
            this.val = val;
            files = new HashMap<>();
        }
    }

    File root;

    public FileSystem() {
        root = new File(0);
    }
    
    public boolean create(String path, int value) {
        String[] pathArr = path.split("/");
        File cur = root;
        for (int i = 1; i < pathArr.length - 1; i++){
            String subDir = pathArr[i];
            File next = cur.files.get(subDir);
            if (next == null) return false;
            cur = next;
        }
        String name = pathArr[pathArr.length - 1];
        File next = cur.files.get(name);
        if (next != null){
            return false;
        }
        cur.files.put(name, new File(value));
        return true;
    }
    
    public int get(String path) {
        String[] pathArr = path.split("/");
        File cur = root;
        for (int i = 1; i < pathArr.length; i++){
            String subDir = pathArr[i];
            File next = cur.files.get(subDir);
            if (next == null) return -1;
            cur = next;
        }
        return cur.val;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.create(path,value);
 * int param_2 = obj.get(path);
 */

//ACC