import java.nio.file.*;
import java.util.*;

public class Trees {

    String name;
    int fileCount;
    long fileSize;
    List<Trees> children;

    public Trees(String name, int fileCount, long fileSize) {
        this.name = name;
        this.fileCount = fileCount;
        this.fileSize = fileSize;
        this.children = new ArrayList<>();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter folder path to scan: ");
        String folderPath = scanner.nextLine();

        Path rootPath = Paths.get(folderPath);
        if (!Files.exists(rootPath) || !Files.isDirectory(rootPath)) {
            System.out.println("Invalid folder path.");
            return;
        }

        Trees root = buildTree(rootPath);
        printTree(root, 0);
    }

    public static Trees buildTree(Path path) throws Exception {
        int fileCount = 0;
        long totalSize = 0;
        List<Trees> children = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    Trees childNode = buildTree(entry);
                    children.add(childNode);
                } else {
                    fileCount++;
                    totalSize += Files.size(entry);
                }
            }
        }

        Trees node = new Trees(path.getFileName().toString(), fileCount, totalSize);
        node.children.addAll(children);
        return node;
    }

    public static void printTree(Trees node, int depth) {
        String indent = "  ".repeat(depth);
        System.out.printf("%s📁 %s | Files: %d | Size: %d bytes%n",
                indent, node.name, node.fileCount, node.fileSize);

        for (Trees child : node.children) {
            printTree(child, depth + 1);
        }
    }
}
