import streamlit as st
from transformers import pipeline


@st.cache_resource
def load_model():
    return pipeline(
        "sentiment-analysis",
        model="cardiffnlp/twitter-roberta-base-sentiment-latest",
        tokenizer="cardiffnlp/twitter-roberta-base-sentiment-latest",
        framework="pt",
    )


classifier = load_model()

st.set_page_config(page_title="Sentiment Analysis App", page_icon="😊")
st.title("💬 Sentiment Analysis (Positive / Neutral / Negative)")
st.write("Enter text below to analyze sentiment.")

text = st.text_area("Enter your text here:")

if st.button("Analyze Sentiment"):
    if text.strip() == "":
        st.warning("Please enter some text.")
    else:
        result = classifier(text)[0]
        raw_label = result["label"].lower()
        score = result["score"]

        if raw_label in ["positive", "neutral", "negative"]:
            label = raw_label
        else:
            label_map = {
                "label_0": "negative",
                "label_1": "neutral",
                "label_2": "positive",
            }
            label = label_map[raw_label]

        st.subheader("Result")
        st.write(f"**Sentiment:** {label.upper()}")
        st.write(f"**Confidence Score:** {score:.2f}")

        if label == "positive":
            st.success("😊 Positive sentiment detected")
        elif label == "neutral":
            st.info("😐 Neutral sentiment detected")
        else:
            st.error("😠 Negative sentiment detected")
