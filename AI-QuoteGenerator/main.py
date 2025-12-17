from transformers import pipeline
import random

# Load text-generation model (small, fast, CPU-friendly)
generator = pipeline("text-generation", model="distilgpt2")


def generate_quote(topic=None):
    """
    Generate a short quote.
    Optionally guide the model using a topic.
    """
    if topic:
        prompt = f"Give a short inspirational quote about {topic}:"
    else:
        prompt = "Give a short inspirational quote:"

    output = generator(
        prompt,
        max_length=40,
        num_return_sequences=1,
        do_sample=True,
        temperature=0.9,
        top_p=0.95,
    )

    text = output[0]["generated_text"]

    # Remove the prompt part
    quote = text.replace(prompt, "").strip()
    return quote


def main():
    print("=== AI Quote Generator ===")
    print("Press ENTER for random quote")
    print("Type a topic (e.g. life, coding, success)")
    print("Type 'exit' to quit\n")

    while True:
        user_input = input("Topic: ").strip()

        if user_input.lower() == "exit":
            print("Goodbye.")
            break

        topic = user_input if user_input else None
        quote = generate_quote(topic)

        print("\nQuote:")
        print(f'"{quote}"')
        print("-" * 40)


if __name__ == "__main__":
    main()
