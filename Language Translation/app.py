import streamlit as st
from transformers import pipeline


@st.cache_resource
def load_translator():
    return pipeline("translation_en_to_hi", model="Helsinki-NLP/opus-mt-en-hi")


translator = load_translator()

st.set_page_config(
    page_title="English → Hindi Translator", page_icon="🌐", layout="centered"
)

st.title("🌐 English → Hindi Translator")
st.write("Powered by **Helsinki-NLP OPUS-MT**")

english_text = st.text_area(
    "Enter English text:",
    height=150,
    placeholder="Machine learning is changing the world.",
)

if st.button("Translate"):
    if english_text.strip() == "":
        st.warning("Please enter some text.")
    else:
        with st.spinner("Translating..."):
            result = translator(english_text)
            hindi_text = result[0]["translation_text"]

        st.success("Translation complete")
        st.text_area("Hindi Translation:", value=hindi_text, height=150)
