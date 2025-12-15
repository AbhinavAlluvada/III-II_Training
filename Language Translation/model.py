from transformers import pipeline

translator = pipeline(
    "translation_en_to_hi",
    model="Helsinki-NLP/opus-mt-en-hi"
)

text = "Artificial intelligence is changing the world."
result = translator(text)

print(result[0]["translation_text"])
