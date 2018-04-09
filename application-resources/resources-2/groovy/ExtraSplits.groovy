matcher = content =~ ';;;+'
while(matcher.find()) {
  FeatureMap fm = Factory.newFeatureMap();
  fm.put("rule", "ColonicSplit");
  fm.put("kind", "external");
  outputAS.add(matcher.start(), 
               matcher.end(),
               "Split", fm);
}


matcher1 = content =~ ';;+'
while(matcher1.find()) {
  FeatureMap fm = Factory.newFeatureMap();
  fm.put("rule", "Semicolons");
  outputAS.add(matcher1.start(), 
               matcher1.end(),
               "Delimiter", fm);
}

//this is a very rough way of doing some sectioning, like
// Medications: X, Y and Z
//and ensuring that it is separate from surrounding text
//given that we often lose the formatting
matcher2 = content =~ ' [A-Z][a-z]+:'
while(matcher2.find()) {
  FeatureMap fm = Factory.newFeatureMap();
  fm.put("rule", "Sections");
  fm.put("kind", "external");
  outputAS.add(matcher2.start(), 
               matcher2.start()+1,
               "Split", fm);
}
