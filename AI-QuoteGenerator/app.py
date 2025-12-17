import streamlit as st
from transformers import pipeline


# Cache the model so it loads only once
@st.cache_resource
def load_model():
    return pipeline("text-generation", model="distilgpt2")


generator = load_model()


def generate_quote(topic=None):
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
    return text.replace(prompt, "").strip()


# ---------------- Streamlit UI ----------------

st.set_page_config(page_title="AI Quote Generator", page_icon="✨", layout="centered")

st.title("✨ AI Quote Generator")
st.write("Generate original quotes using an AI language model.")

topic = st.text_input("Optional topic", placeholder="life, success, coding...")

if st.button("Generate Quote"):
    with st.spinner("Thinking..."):
        quote = generate_quote(topic if topic else None)

    st.markdown("### Quote")
    st.success(f"“{quote}”")
