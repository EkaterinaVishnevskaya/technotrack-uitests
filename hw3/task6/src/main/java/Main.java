public class Main {
    public static void main(String... args) {
        int ans[] = Solver.Solve(ArgumentClass.class);
        System.out.println("Private fields: " + ans[0] + ";\nprotected fields: " + ans[1] + ";\npublic fields: " + ans[1] + ".");
    }
}
