import stack.StackImplementation;

void main() {
    StackImplementation<String> stack = new StackImplementation<>(1);
    stack.push("Hello");
    stack.push(" ");
    stack.push("World!");
    stack.push("Look");
    stack.push("Easy");

    System.out.println(stack);

    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    System.out.println(stack);
}
